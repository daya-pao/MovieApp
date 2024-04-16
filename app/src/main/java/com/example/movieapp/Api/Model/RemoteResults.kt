package com.example.movieapp.Api.Model

data class RemoteResults(
    val page: Int,
    val results: List<ResultMV>,
    val total_pages: Int,
    val total_results: Int
)