package com.test.mandiri.newsappkt.network

import com.google.gson.annotations.SerializedName
import com.test.mandiri.newsappkt.data.source.SourceModel
import java.util.*
import kotlin.collections.ArrayList

class ResponseSource (
    @SerializedName("status")
    private var status: String? = null,

    @SerializedName("sources")
    private var sources: ArrayList<SourceModel?>? = null
) {
    fun getSources(): ArrayList<SourceModel?>? {
        return this.sources
    }
}