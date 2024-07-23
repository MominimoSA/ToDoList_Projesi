package org.tmo.taskmanagersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmo.taskmanagersystem.model.Users;

// entity için veri erişim işlemlerini gerçekleştiren repository sınıfları oluştur

// integer yerine Long kullandık çünkü veri tabanı primaryKey'lerini yüksek sayıda kayıt desteklemesi için
// Long olarak tanımladık
public interface UsersRepository extends JpaRepository<Users, Long>
{

}
