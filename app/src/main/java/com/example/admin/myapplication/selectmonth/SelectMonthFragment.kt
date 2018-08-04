package jp.co.bleague.ui.selectmonth

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import jp.co.bleague.R
import jp.co.bleague.base.BaseDialogFragment
import jp.co.bleague.databinding.FragmentSelectMonthBinding

class SelectMonthFragment : BaseDialogFragment<FragmentSelectMonthBinding, SelectMonthViewModel>(), SelectMonthNavigator {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_select_month

    override val viewModel: SelectMonthViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(SelectMonthViewModel::class.java)

    private var selectMonthAdapter: SelectMonthAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Dialog_NoTitle)
        dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        viewModel.navigator = this
        selectMonthAdapter = SelectMonthAdapter()
        viewDataBinding.recyclerView.adapter = selectMonthAdapter
        selectMonthAdapter!!.submitList(listOf("1", "2", "3"))
        viewDataBinding.recyclerView.adapter.notifyDataSetChanged()
    }
}