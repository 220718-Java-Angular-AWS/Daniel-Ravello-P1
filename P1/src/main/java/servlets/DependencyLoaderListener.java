package servlets;

import DAOs.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

    public class DependencyLoaderListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            ConnectionManager.getConnection();

        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {

        }
    }


