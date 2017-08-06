package com.yoyo.gamecenter.service.impl;

import com.yoyo.gamecenter.dao.TermianlDao;
import com.yoyo.gamecenter.model.Terminal;
import com.yoyo.gamecenter.service.TerminalService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class TerminalServiceImplTest extends TestCase {

    @Resource
    private TerminalService terminalService;

    @Test
    public void testGetAllTerminal() throws Exception {
        List<Terminal> allTerminal = terminalService.getAllTerminal();
        System.out.println(allTerminal);
    }

    @Test
    public void testGetTerminalById() throws Exception {
        Terminal terminal = terminalService.getTerminalById((long) 1);
        System.out.println(terminal);
    }

    @Test
    public void testGetTerminalByName() throws Exception {
        Terminal terminal = terminalService.getTerminalByName("ff4f93fd6518");
        System.out.println(terminal);
    }

    @Test
    public void testGetTerminalByNo() throws Exception{
        Terminal terminal = terminalService.getTerminalByNo("ff4f93fd6520");
        System.out.println(terminal);
    }

    @Test
    public void testAddTerminal() throws Exception {
        Terminal terminal = new Terminal();
        terminal.setTerminalNo("ff4f93feeeee");
        terminal.setTerminalName("ff4f93feeeee");
        terminal.setuId(6);
        terminal.setActivationDate(new Date());
        terminalService.addTerminal(terminal);
    }

    @Test
    public void testUpdateTerminal() throws Exception {
        Terminal terminal = new Terminal();
        terminal.settId(2);
        terminal.setTerminalName("wuqingyou");
        terminalService.updateTerminal(terminal);
    }

    @Test
    public void testSelectAllTerminalsByUserId() throws Exception{
        List<Terminal> allTerminalByUserId = terminalService.getAllTerminalByUserId((long) 6);
        System.out.println(allTerminalByUserId.get(0));
    }

    @Test
    public void testQueryByPage() throws Exception{
        List<Terminal> terminals = terminalService.queryByPage((long) 6,0,5,"测试");
        System.out.println(terminals);
    }

    @Test
    public void testGetTerminalCount() throws Exception{
        int terminalCount = terminalService.getTerminalCount((long) 6, null);
        System.out.println(terminalCount);
    }

}