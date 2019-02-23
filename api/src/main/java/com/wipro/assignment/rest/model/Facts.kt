package com.wipro.assignment.rest.model

import com.google.gson.annotations.SerializedName


/**
 * Created by krishnas on 2/22/2019.
 */
class Facts {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("rows")
    var rows: List<Row> = ArrayList()

    class Row {
        @SerializedName("title")
        val title: String? = null
        @SerializedName("description")
        val description: String? = null
        @SerializedName("imageHref")
        val imageHref: String? = null
    }
}