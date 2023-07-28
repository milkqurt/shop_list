package com.example.shoppinglist.domain

import javax.inject.Inject

class RemoveShopItemUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    suspend fun removeShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.removeShopItemUseCase(shopItem)
    }
}