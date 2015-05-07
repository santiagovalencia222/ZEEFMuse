package com.zeef.hackbattle.main;

import com.zeef.client.model.Block;
import com.zeef.client.model.BlockType;
import com.zeef.client.model.Page;
import com.zeef.client.model.Page.PageTypeEnum;
import com.zeef.hackbattle.apiinvoker.Invoker;
import com.zeef.hackbattle.blocksmanager.BlockManager;
import com.zeef.hackbattle.linksmanager.LinkManager;
import com.zeef.hackbattle.pagesmanager.PageManager;


public class Main {

	public Main() {
		Invoker invoker = new Invoker();
		PageManager pagesManager = new PageManager(invoker);
		BlockManager blocksManager = new BlockManager(invoker);
		LinkManager linksManager = new LinkManager(invoker);

		Page page = pagesManager.createPage("Alternative", "en", PageTypeEnum.SUBJECT);
		pagesManager.setMarkdownDesc(page.getId(), "Short description of the Genere");
		Block block = blocksManager.addBlockToPage(page.getId(), BlockType.LINK, "Capital Cities");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/66314771?utm_source=deezer&utm_content=track-66314771&utm_term=276269573_1429791803&utm_medium=web", "Safe and Sound", "Safe and Sound - Capital Cities");

		block = blocksManager.addBlockToPage(page.getId(), BlockType.LINK, "Coldplay");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/3098840?utm_source=deezer&utm_content=track-3098840&utm_term=276269573_1429791843&utm_medium=web", "The Scientist", "The Scientist - Coldplay");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/3098841?utm_source=deezer&utm_content=track-3098841&utm_term=276269573_1429792017&utm_medium=web", "Clocks", "Clocks - Coldplay");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/3128096?utm_source=deezer&utm_content=track-3128096&utm_term=276269573_1429792319&utm_medium=web", "Yellow", "Yellow - Coldplay");

		block = blocksManager.addBlockToPage(page.getId(), BlockType.LINK, "Foo Fighters");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/4311595?utm_source=deezer&utm_content=track-4311595&utm_term=276269573_1429792097&utm_medium=web", "Best Of You", "Best Of You - Foo Figthers");
		linksManager.addLinkToBlock(block.getId(), "http://www.deezer.com/track/4311607?utm_source=deezer&utm_content=track-4311607&utm_term=276269573_1429792124&utm_medium=web", "Wheels", "Wheels - Foo Figthers");
	}
}