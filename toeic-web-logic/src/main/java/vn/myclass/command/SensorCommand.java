package vn.myclass.command;

import vn.myclass.core.dto.SensorDTO;
import vn.myclass.core.web.command.AbstractCommand;

public class SensorCommand extends AbstractCommand {
    public SensorCommand() {
        this.pojo = new SensorDTO();
    }
}
