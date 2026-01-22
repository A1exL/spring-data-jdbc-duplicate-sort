package user.mgmt.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.testcontainers.mssqlserver.MSSQLServerContainer;
import user.mgmt.UserManagementApp;

@SpringBootTest(classes = UserManagementApp.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static MSSQLServerContainer mssqlServer;

    @BeforeAll
    static void setUp() {
        mssqlServer = new MSSQLServerContainer("mcr.microsoft.com/mssql/server:2022-CU20-ubuntu-22.04")
                .acceptLicense();
        mssqlServer.start();
    }

    @AfterAll
    static void tearDown() {
        if (null != mssqlServer) {
            mssqlServer.stop();
        }
    }

    @Test
    void findByUsernameUsingSort() {
        Sort sort = Sort.by("lastModified");
        Assertions
                .assertThatCode(() -> userRepository.findByUsername("username", sort))
                .doesNotThrowAnyException();
    }

    @Test
    void findByUsernameUsingPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("lastModified"));
        Assertions
                .assertThatCode(() -> userRepository.findByUsername("username", pageable))
                .doesNotThrowAnyException();
    }
}