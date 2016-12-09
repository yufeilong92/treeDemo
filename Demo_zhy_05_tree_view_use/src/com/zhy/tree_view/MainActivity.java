package com.zhy.tree_view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.zhy.bean.FileBean;
import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;
import com.zhy.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

public class MainActivity extends Activity
{
	private List<FileBean> mDatas = new ArrayList<FileBean>();
	private ListView mTree;
	private TreeListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		try
		{
			mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas, 10);
			
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener()
			{
				@Override
				public void onClick(Node node, int position)
				{
					if (node.isLeaf())
					{
						Toast.makeText(getApplicationContext(), node.getName(),
								Toast.LENGTH_SHORT).show();
					}
				}

			});
			
			mTree.setAdapter(mAdapter);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		

	}

	private void initDatas()
	{

		// id , pid , label , 其他属性
		mDatas.add(new FileBean(1, 0, "文件管理系统"));
		mDatas.add(new FileBean(2, 1, "游戏"));
		mDatas.add(new FileBean(3, 1, "文档"));
		mDatas.add(new FileBean(4, 1, "程序"));
		mDatas.add(new FileBean(5, 2, "war3"));
		mDatas.add(new FileBean(6, 2, "刀塔传奇"));

		mDatas.add(new FileBean(7, 4, "面向对象"));
		mDatas.add(new FileBean(8, 4, "非面向对象"));

		mDatas.add(new FileBean(9, 7, "C++"));
		mDatas.add(new FileBean(10, 7, "JAVA"));
		mDatas.add(new FileBean(11, 7, "Javascript"));
		mDatas.add(new FileBean(12, 8, "C语言"));

	}

}
