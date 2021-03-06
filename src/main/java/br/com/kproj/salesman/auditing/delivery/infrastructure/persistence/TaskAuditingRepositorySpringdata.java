package br.com.kproj.salesman.auditing.delivery.infrastructure.persistence;


import br.com.kproj.salesman.infrastructure.entity.auditing.TaskAudinting;
import br.com.kproj.salesman.infrastructure.repository.BaseRepositoryLegacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskAuditingRepositorySpringdata extends BaseRepositoryLegacy<TaskAudinting, Long> {



    @Query("SELECT ta FROM TaskAudinting AS ta WHERE ta.entityId = :entityId ORDER BY ta.lastUpdate desc ")
    Page<TaskAudinting> findLasVersion(@Param("entityId") Long entityId, Pageable pageable);

    @Query("SELECT ta FROM TaskAudinting AS ta WHERE ta.entityId = :entityId ORDER BY ta.lastUpdate desc ")
    Page<TaskAudinting> findAll(@Param("entityId") Long entityId, Pageable pageable);

}
