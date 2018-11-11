package com.ngu.postgresing.repo;

import com.ngu.postgresing.domain.feature.AppFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppFeatureRepo extends JpaRepository<AppFeature, Long>
{

}
