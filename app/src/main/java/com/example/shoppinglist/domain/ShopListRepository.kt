package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    suspend fun getShopItem(id: Int): ShopItem?

    suspend fun removeShopItemUseCase(shopItemId: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

    suspend fun addShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

}