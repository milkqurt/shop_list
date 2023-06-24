package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopItem(id: Int): ShopItem?

    fun removeShopItemUseCase(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun addShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

}