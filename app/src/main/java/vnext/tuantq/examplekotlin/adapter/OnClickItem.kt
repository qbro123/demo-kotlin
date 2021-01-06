package vnext.tuantq.examplekotlin.adapter

import vnext.tuantq.examplekotlin.entity.News

interface OnClickItem {
    fun clickItem(news: News)
}