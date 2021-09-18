package com.rapidlearner.goodworklabstask.model

data class PostData(
    val metadata: Metadata? = null,
    val data:List<Data>? = null
)

data class Metadata(
    val pagination:PaginationData? = null,
    )

data class PaginationData(
    val total:Int? = null,
    val pages:Int? = null,
    val page:Int? = null,
    val limit:Int? = null,
    val links:LinkData? = null
)

data class LinkData(
    val previous:String? = null,
    val current:String? = null,
    val next:String? = null
)

data class Data(
    val id:Int? = null,
    val user_id:Int? = null,
    val title:String? = null,
    val body:String? = null
)


