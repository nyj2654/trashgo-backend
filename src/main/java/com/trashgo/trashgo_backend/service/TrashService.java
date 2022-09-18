package com.trashgo.trashgo_backend.service;

import com.trashgo.trashgo_backend.domain.model.Trash;
import com.trashgo.trashgo_backend.domain.model.User;
import com.trashgo.trashgo_backend.domain.repository.TrashRepository;
import com.trashgo.trashgo_backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashService {

    @Autowired
    TrashRepository trashRepository;

    public Trash findById(Long id){
        return trashRepository.findById(id).get();
    }

    public List<Trash> findAll(){
        return trashRepository.findAll();
    }

    public Trash save(Trash trash) {
        return trashRepository.save(trash);
    }
}
