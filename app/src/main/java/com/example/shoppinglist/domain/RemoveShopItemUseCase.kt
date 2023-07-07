package com.example.shoppinglist.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun removeShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.removeShopItemUseCase(shopItem)
    }
}