package jp.co.bleague.ui.selectmonth

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import jp.co.bleague.R
import jp.co.bleague.base.BaseRecyclerAdapter
import jp.co.bleague.databinding.ItemMonthOfYearBinding
import jp.co.bleague.model.TeamItem

class SelectMonthAdapter : BaseRecyclerAdapter<Any, ItemMonthOfYearBinding>(DIFF_CALLBACK) {

    private companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(
                    oldItem: Any, newItem: Any): Boolean {
                return true
            }

            override fun areContentsTheSame(
                    oldItem: Any, newItem: Any): Boolean {
                return false
            }
        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemMonthOfYearBinding {
        val binding = DataBindingUtil.inflate<ItemMonthOfYearBinding>(LayoutInflater.from(parent.context), R.layout.item_month_of_year, parent, false)
        return binding
    }

    override fun bind(binding: ItemMonthOfYearBinding, item: Any) {

    }


}