package org.maslov.template.service;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoServiceStubImpl implements DemoService {

    @Override
    public String getNetwork() {
        return "Polygon";
    }

    @Override
    public String getContractAddress() {
        return "0xDEADBEEFDEADBEEFDEADBEEFDEADBEEFDEADBEEFDEADBEEF";
    }

    @Override
    public String getInworkerAddress() {
        return "0xDEADBEEFDEADBEEFDEADBEEFDEADBEEFDEADBEEFDEADBEEF";
    }

    @Override
    public String getInworkerPK() {
        return "g;lfkdjg;gjklgjfklgjdf;gkj";
    }

    @Override
    public String getCommitHash() {
        return "68edcb005b9d8ca542334de68581f88f42dd60ad";
    }

    @PreDestroy
    @Override
    public void preDestroy() {
      log.info("In predestroy of " + this.getClass().getSimpleName());
    }


}
