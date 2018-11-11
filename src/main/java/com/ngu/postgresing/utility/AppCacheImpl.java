package com.ngu.postgresing.utility;

import com.ngu.postgresing.domain.feature.AppFeature;
import com.ngu.postgresing.domain.feature.AppFeatureSetting;
import com.ngu.postgresing.repo.AppFeatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

@Component
public class AppCacheImpl implements AppCache
{
    private Properties appProperties;

    @Autowired
    private AppFeatureRepo appFeatureRepo;


    @EventListener(ApplicationReadyEvent.class)
    public void reloadApplicationSettings()
    {
        appProperties = null;
        appProperties = new Properties();

        List<AppFeature> features = appFeatureRepo.findAll();
        for(AppFeature feature : features)
        {
            for(AppFeatureSetting setting : feature.getAppFeatureSettings())
            {
                appProperties.setProperty(setting.getAppfeaturekey(), setting.getAppfeaturevalue());
            }
        }
    }

    @Override
    public Properties getApplicationSettings()
    {
        return appProperties;
    }

    public AppFeatureRepo getAppFeatureRepo() {
        return appFeatureRepo;
    }

    public void setAppFeatureRepo(AppFeatureRepo appFeatureRepo) {
        this.appFeatureRepo = appFeatureRepo;
    }
}
