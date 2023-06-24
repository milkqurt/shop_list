package com.example.shoppinglist.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun removeShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.removeShopItemUseCase(shopItem)
    }
}