package com.tyba.repository.db

import androidx.room.*
import com.tyba.common.data.Exclusion
import com.tyba.common.data.ExclusionBaseObject
import com.tyba.common.data.Feature
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable


@Dao
interface FeaturesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeatures(list: List<Feature>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExclusions(list: List<ExclusionBaseObject>): Completable

    @Query("Delete from exclusions")
    fun delete():Completable

    @Query("Select * from feature")
    fun getAllFeatures(): Flowable<List<Feature>>

    @Query("Select * from exclusions")
    fun getAllExclusions(): Flowable<List<ExclusionBaseObject>>
}