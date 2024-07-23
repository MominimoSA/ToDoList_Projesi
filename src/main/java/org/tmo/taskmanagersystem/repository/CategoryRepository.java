package org.tmo.taskmanagersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmo.taskmanagersystem.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
