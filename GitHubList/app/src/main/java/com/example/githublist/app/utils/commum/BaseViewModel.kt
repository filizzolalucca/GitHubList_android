package com.example.githublist.app.utils.commum


import androidx.lifecycle.*
import com.example.githublist.app.utils.commum.exception.CacheException
import com.example.githublist.app.utils.commum.exception.NetworkException
import com.example.githublist.app.utils.commum.exception.RepositoryException
import kotlinx.coroutines.launch
import timber.log.Timber


open class BaseViewModel:ViewModel() {

   val showLoading by lazy { SingleLiveEvent<Void>() }
   val hideLoading by lazy { SingleLiveEvent<Void>() }
   val showError by lazy { SingleLiveEvent<ViewModelString>() }

   protected fun doAsyncWork(
      shouldShowLoading: Boolean = true,
      exceptionHandler: (Exception) -> Unit = ::handleException,
      work: suspend () -> Unit
   ) {
      viewModelScope.launch {
         doWork(shouldShowLoading, exceptionHandler, work)
      }
   }


   private suspend fun <T> doWork(
      shouldShowLoading: Boolean = true,
      exceptionHandler: (Exception) -> Unit,
      work: suspend () -> T
   ): T? {
      return try {
         if (shouldShowLoading) {
            showLoading.call()
         }
         work()
      } catch (e: Exception) {
         Timber.e(e)
         exceptionHandler(e)
         null
      } finally {
         if (shouldShowLoading) {
            hideLoading.call()
         }
      }
   }

   private fun handleException(e: Exception) {
      val errorMessage = when (e) {
         is NetworkException -> ViewModelString(
            com.example.githublist.R.string.error_connection,
            NetworkException()
         )
         is RepositoryException -> e.message?.let {
            if (it.isNotBlank()) ViewModelString(
               it
            ) else null
         } ?: ViewModelString(
            com.example.githublist.R.string.error_repository,
            RepositoryException()
         )
         is CacheException -> return
         else -> ViewModelString(
            com.example.githublist.R.string.error_other,
            Exception()
         )
      }
      showError.call(errorMessage)
   }
}