package eu.codlab.amiiwrite.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.structure.BaseModel;

import eu.codlab.amiiwrite.database.controllers.AmiiboController;

/**
 * Created by kevinleperf on 31/10/2015.
 */
@Table(databaseName = Database.NAME)
public class Amiibo extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String name;

    @Column
    public String uuid;

    @Column
    public String game_name;

    @Column
    public long created_at;

    /**
     * Identifier, it is extracted from the blob but here for clarity issue
     */
    @Column
    public String amiibo_identifier;

    @Column(defaultValue = "false")
    public boolean synced;

    @Column
    public Blob data;

    private AmiiboDescriptor descriptor;


    public AmiiboDescriptor getDescriptor() {
        if (descriptor == null) {
            descriptor = AmiiboController.getInstance().getAmiiboDescriptor(amiibo_identifier);
        }
        return descriptor;
    }
}
