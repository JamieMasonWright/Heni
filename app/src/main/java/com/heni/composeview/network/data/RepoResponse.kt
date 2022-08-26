package com.heni.composeview.network.data

import com.google.gson.annotations.SerializedName


data class RepoResponse (

  @SerializedName("id"                          ) var id                       : Int              = 0,
  @SerializedName("node_id"                     ) var nodeId                   : String?           = null,
  @SerializedName("name"                        ) var name                     : String?           = null,
  @SerializedName("full_name"                   ) var fullName                 : String           = "sample",
  @SerializedName("owner"                       ) var owner                    : Owner?            = Owner(),
  @SerializedName("created_at"                  ) var createdAt                : String?           = null,
  @SerializedName("updated_at"                  ) var updatedAt                : String?           = null,
  @SerializedName("pushed_at"                   ) var pushedAt                 : String?           = null,
  @SerializedName("size"                        ) var size                     : Int              = 0
)