package com.example.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(application: Application) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val shopListMapper = ShopListMapper()

    override suspend fun getShopItem(id: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(id)
        return shopListMapper.mapDbModelToEntity(dbModel)
    }

    override suspend fun removeShopItemUseCase(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(shopListMapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(shopListMapper.mapEntityToDbModel(shopItem))
    }

    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopListDao.getShopList()){
            value = shopListMapper.mapListDbModelToListEntity(it)
        }
    }
}