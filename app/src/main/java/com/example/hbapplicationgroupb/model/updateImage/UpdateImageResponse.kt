package com.example.hbapplicationgroupb.model.updateImage

data class UpdateImageResponse(
    val `data`: Data,
    val message: String,
    val statusCode: Int,
    val succeeded: Boolean
)