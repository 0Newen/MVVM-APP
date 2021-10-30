package com.example.mvvmapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapp.data.model.Acronym
import com.example.mvvmapp.data.repository.MainRepository
import com.example.mvvmapp.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val acronyms = MutableLiveData<Resource<List<Acronym>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchAcronym("")
    }

    private fun fetchAcronym(sf: String) {
        acronyms.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getAcronym(sf)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ acronymList ->
                    acronyms.postValue(Resource.success(acronymList))
                }, { throwable ->
                    acronyms.postValue(Resource.error("Something Went Wrong", data = null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getAcronym(): LiveData<Resource<List<Acronym>>> {
        return acronyms
    }

    fun getNewAcronymResearch(str: String) {
        fetchAcronym(str)
    }
}