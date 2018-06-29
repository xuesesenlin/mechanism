package org.ld.mechanism.admin.account.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

    @Autowired
    private AccountController controller;

    @Test
    public void page() {
        controller.page(0, null);
        controller.page(0, null);
    }
}