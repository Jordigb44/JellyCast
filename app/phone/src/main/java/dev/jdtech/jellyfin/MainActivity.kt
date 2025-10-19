package dev.jdtech.jellyfin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.AndroidEntryPoint
import dev.jdtech.jellyfin.dlna.DlnaDeviceManager
import dev.jdtech.jellyfin.presentation.theme.JellyCastTheme
import dev.jdtech.jellyfin.viewmodels.MainViewModel
import dev.jdtech.jellyfin.work.SyncWorker

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var navigateToItemCallback: ((dev.jdtech.jellyfin.models.JellyCastItem) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Initialize DLNA service
        DlnaDeviceManager.initialize(this)

        setContent {
            val state by viewModel.state.collectAsStateWithLifecycle()

            JellyCastTheme(
                dynamicColor = state.isDynamicColors,
            ) {
                val navController = rememberNavController()
                val navigateFn =
                    remember {
                        { item: dev.jdtech.jellyfin.models.JellyCastItem ->
                            dev.jdtech.jellyfin.navigateToItem(navController, item)
                        }
                    }
                navigateToItemCallback = navigateFn
                if (!state.isLoading) {
                    NavigationRoot(
                        navController = navController,
                        hasServers = state.hasServers,
                        hasCurrentServer = state.hasCurrentServer,
                        hasCurrentUser = state.hasCurrentUser,
                    )
                }
            }
        }

        scheduleUserDataSync()
    }

    private fun scheduleUserDataSync() {
        val syncWorkRequest =
            OneTimeWorkRequestBuilder<SyncWorker>()
                .setConstraints(
                    Constraints
                        .Builder()
                        .setRequiredNetworkType(
                            NetworkType.CONNECTED,
                        ).build(),
                ).build()

        val workManager = WorkManager.getInstance(applicationContext)

        workManager
            .beginUniqueWork("syncUserData", ExistingWorkPolicy.KEEP, syncWorkRequest)
            .enqueue()
    }

    fun navigateToItem(item: dev.jdtech.jellyfin.models.JellyCastItem) {
        navigateToItemCallback?.invoke(item)
    }
}
