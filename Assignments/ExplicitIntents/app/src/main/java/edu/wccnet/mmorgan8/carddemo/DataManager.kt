package edu.wccnet.mmorgan8.carddemo

class DataManager {

    companion object {
        val titles = mutableListOf(
            "Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight"
        )

        val details = mutableListOf(
            "Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details"
        )

        val images = mutableListOf(
            R.drawable.android_image_1,
            R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8
        )

        init {
            titles.shuffle()
            details.shuffle()
            images.shuffle()
        }

    }

}