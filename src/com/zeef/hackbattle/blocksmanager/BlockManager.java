package com.zeef.hackbattle.blocksmanager;

import com.zeef.client.api.BlockApi;
import com.zeef.client.api.PageApi;
import com.zeef.client.model.Block;
import com.zeef.client.model.BlockType;
import com.zeef.client.model.Page;
import com.zeef.hackbattle.apiinvoker.Invoker;

public class BlockManager {

	private Invoker invoker;

	public BlockManager(Invoker invoker) {
		this.invoker = invoker;
	}

	public Block addBlockToPage(Long pageId, BlockType blockType, String title) {
		PageApi pageApi = new PageApi(invoker.getAPIInvoker());
		Page page = pageApi.addBlock(pageId, blockType, title, 1, true, true);
		Block block = null;
		for (Block blockInPage : page.getBlocks()) {
			if (blockInPage.getTitle().equals(title)) {
				block = blockInPage;
			}
		}
		return block;
	}

	public void deleteBlock(Long blockId) {
		BlockApi blockApi = new BlockApi(invoker.getAPIInvoker());
		blockApi.deleteBlockByID(blockId);
	}
}
