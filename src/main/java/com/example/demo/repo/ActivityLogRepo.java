package com.example.demo.repo;

import com.example.demo.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {
    // Your custom queries or methods, if needed
}
