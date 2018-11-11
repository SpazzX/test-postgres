package com.ngu.postgresing.controller;

import com.ngu.postgresing.domain.feature.AppFeature;
import com.ngu.postgresing.domain.feature.AppFeatureSetting;
import com.ngu.postgresing.repo.AppFeatureRepo;
import com.ngu.postgresing.repo.AppFeatureSettingRepo;
import com.ngu.postgresing.utility.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Properties;

@RestController
public class AppFeatureController
{
    @Autowired
    private AppFeatureRepo appFeatureRepo;
    @Autowired
    private AppFeatureSettingRepo appFeatureValueRepo;
    @Autowired
    private AppCache appCache;

    @GetMapping("/features")
    public List<AppFeature> getFeatures()
    {
        return appFeatureRepo.findAll();
    }

    @GetMapping("/featurescache")
    public List<AppFeature> getFeaturesFromCache()
    {
        Properties properties = appCache.getApplicationSettings();
        System.out.println("Just For Testing");
        return null;
    }

    @GetMapping("/feature/{appFeatureId}/settings")
    public @ResponseBody Page<AppFeatureSetting> getAppFeatureSettingsByID(@PathVariable("appFeatureId") long appFeatureId, Pageable pageable)
    {
        return appFeatureValueRepo.findByAppfeature_id(appFeatureId, pageable);
    }

    public AppFeatureRepo getAppFeatureRepo() {
        return appFeatureRepo;
    }

    public void setAppFeatureRepo(AppFeatureRepo appFeatureRepo) {
        this.appFeatureRepo = appFeatureRepo;
    }

    public AppFeatureSettingRepo getAppFeatureValueRepo() {
        return appFeatureValueRepo;
    }

    public void setAppFeatureValueRepo(AppFeatureSettingRepo appFeatureValueRepo) {
        this.appFeatureValueRepo = appFeatureValueRepo;
    }

    public AppCache getAppCache() {
        return appCache;
    }

    public void setAppCache(AppCache appCache) {
        this.appCache = appCache;
    }
}
