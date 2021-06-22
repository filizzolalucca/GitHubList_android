package com.example.githublist.app.utils.commum.exception

open class RepositoryException(message: String? = null, cause: Throwable? = null) :
    Exception(message ?: cause?.message, cause)