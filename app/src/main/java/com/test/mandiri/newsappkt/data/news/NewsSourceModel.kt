package com.test.mandiri.newsappkt.data.news

import com.google.gson.annotations.SerializedName

class NewsSourceModel (
    @SerializedName("id")
     var id: String? = null,

    @SerializedName("name")
     val name: String? = null
)