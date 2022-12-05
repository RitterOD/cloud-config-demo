package org.maslov.template.service;

public interface DemoService {
    String getNetwork();

    String getContractAddress();

    String getInworkerAddress();

    String getInworkerPK();

    String getCommitHash();

    void preDestroy();
}
