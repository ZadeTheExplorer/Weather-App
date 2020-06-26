package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterface;
import com.example.weather.Retrofit.OpenWeatherApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView search;
    TextView nameText, weatherText;
    TextView tempText, feelText, humidityText;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.textField);
        search = findViewById(R.id.search);

        nameText = findViewById(R.id.nameText);
        weatherText = findViewById(R.id.weatherText);
        tempText = findViewById(R.id.tempText);
        feelText = findViewById(R.id.feelText);
        humidityText = findViewById(R.id.humidityText);

        search.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call API
                getWeatherData(textField.getText().toString().trim());
            }
        });

    }

    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<OpenWeatherApi> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<OpenWeatherApi>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<OpenWeatherApi> call, Response<OpenWeatherApi> response) throws NullPointerException {
                if (response.body() != null) {

                    nameText.setText(response.body().getName());
                    weatherText.setText("Weather: " + response.body().getWeatherList().get(0).getDescription());

                    tempText.setText("Temp: " + response.body().getMain().getTemp());
                    feelText.setText("Feels like: " + response.body().getMain().getFeels_like());
                    humidityText.setText("Humidity: " + response.body().getMain().getHumidity());
                }
            }

            @Override
            public void onFailure(Call<OpenWeatherApi> call, Throwable t) {

            }
        });
    }
}