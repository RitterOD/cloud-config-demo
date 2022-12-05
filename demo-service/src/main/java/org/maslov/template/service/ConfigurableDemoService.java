package org.maslov.template.service;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RefreshScope
public class ConfigurableDemoService implements DemoService{


    private final String network;
    private final String contractAddress;
    private final String inworkerAddress;
    private final String inworkerPrivateKey;
    private final String commitHash;

    public ConfigurableDemoService(@Value("${demoservice.network}") String network,
                                   @Value("${demoservice.contractAddress}") String contractAddress,
                                   @Value("${demoservice.inworkerAddress}") String inworkerAddress,
                                   @Value("${demoservice.inworkerPrivateKey}") String inworkerPrivateKey,
                                   @Value("${config.client.version}") String commitHash) {
        this.network = network;
        this.contractAddress = contractAddress;
        this.inworkerAddress = inworkerAddress;
        this.inworkerPrivateKey = inworkerPrivateKey;
        this.commitHash = commitHash;
    }

    @Override
    public String getNetwork() {
        return network;
    }

    @Override
    public String getContractAddress() {
        return contractAddress;
    }

    @Override
    public String getInworkerAddress() {
        return inworkerAddress;
    }

    @Override
    public String getInworkerPK() {
        return inworkerPrivateKey;
    }

    @Override
    public String getCommitHash() {
        return commitHash;
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        log.info("in predestroy: " + this.getClass().getSimpleName());
    }
}
