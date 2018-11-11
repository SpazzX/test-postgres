package com.ngu.postgresing.repo;

import com.ngu.postgresing.domain.feature.AppFeatureSetting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppFeatureSettingRepo extends JpaRepository<AppFeatureSetting, Long>
{
    Page<AppFeatureSetting> findByAppfeature_id(long appfeatureID, Pageable pageable);
}
