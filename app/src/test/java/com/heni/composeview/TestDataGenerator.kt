package com.heni.composeview

import com.heni.composeview.network.data.Owner
import com.heni.composeview.network.data.RepoResponse

internal fun mockRepoData(
    id : Int = 0,
    nodeId : String = "sample",
    name : String  = "sample",
    fullName : String = "sample",
    owner : Owner = Owner(id = 0, nodeId = "sample", avatarUrl = "sample"),
    createdAt : String = "sample",
    updatedAt : String = "sample",
    pushedAt : String = "sample",
    size : Int = 0
) = RepoResponse(
    id,
    nodeId,
    name,
    fullName,
    owner,
    createdAt,
    updatedAt,
    pushedAt,
    size
)