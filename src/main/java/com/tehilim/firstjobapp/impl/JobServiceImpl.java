package com.tehilim.firstjobapp.impl;

import com.tehilim.firstjobapp.model.Job;
import com.tehilim.firstjobapp.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 0L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(++nextId);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
