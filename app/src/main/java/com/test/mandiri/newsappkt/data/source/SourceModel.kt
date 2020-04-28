package com.test.mandiri.newsappkt.data.source

import com.google.gson.annotations.SerializedName

class SourceModel (
    @SerializedName("id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("language")
    var language: String? = null,

    @SerializedName("country")
    var country: String? = null

)