package org.tmo.taskmanagersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmo.taskmanagersystem.model.Users;

// entity için veri tabanı erişim method'larını tanımlayacağımız repository
// interface'imizi oluşturduk.
// integer yerine Long kullandık çünkü veri tabanı primaryKey'lerini yüksek
// sayıda kayıt desteklemesi için Long olarak tanımladık
public interface UsersRepository extends JpaRepository<Users, Long>
{

}
