package com.example.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Domain.Baseballteam;
import com.example.Repository.BaseballRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballServiceTest {
	
	@Autowired
	private BaseballRepository baseballRepository;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testshowDetail() {
		System.out.println("showDetailテスト開始");
		
		Baseballteam resultbaseballteam = baseballRepository.showDetail(2);

		assertThat("球団名が違います", resultbaseballteam.getTeamName(), is("阪神タイガース"));
		assertThat("発足日が違います", resultbaseballteam.getInauguration(), is("1935年12月10日"));
		assertThat("ホーム球場名が違います", resultbaseballteam.getHeadquarters(), is("阪神甲子園球場（兵庫県・西宮市）"));
		
		System.out.println("showDetailテスト終了");
	}
	
	@Test
	public void testshowList() {
		System.out.println("リスト検索テスト開始");
		
		List<Baseballteam> baseballList = baseballRepository.showList();
		assertThat("エラー", baseballList.get(0).getTeamName() , is("読売ジャイアンツ"));
		assertThat("エラー", baseballList.get(0).getHeadquarters(), is("東京ドーム（東京都・文京区）"));
		assertThat("エラー", baseballList.get(0).getInauguration(), is("1934年12月26日"));
		
		System.out.println("リスト検索テスト終了");
	}

}
