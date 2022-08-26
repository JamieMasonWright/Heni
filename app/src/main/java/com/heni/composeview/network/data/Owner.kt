package com.heni.composeview.network.data

import com.google.gson.annotations.SerializedName


data class Owner (

  @SerializedName("id"                  ) var id                : Int?     = null,
  @SerializedName("node_id"             ) var nodeId            : String?  = null,
  @SerializedName("avatar_url"          ) var avatarUrl         : String?  = null

)