package com.example.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(application: Application) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val shopListMapper = ShopListMapper()

    override fun getShopItem(id: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(id)
        return shopListMapper.mapDbModelToEntity(dbModel)
    }

    override fun removeShopItemUseCase(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(shopListMapper.mapEntityToDbModel(shopItem))
    }

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(shopListMapper.mapEntityToDbModel(shopItem))
    }

    override fun getShopList(): LiveData<List<ShopItemDbModel>> {
        return shopListDao.getShopList()
    }
}