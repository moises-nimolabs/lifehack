using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Newtonsoft.Json;
using System.Net.Http;
using System.Threading.Tasks;

namespace LifeHack.Api.Controllers
{
    /// <summary>
    /// Handles the person via the main Data Api
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class PersonController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;
        private readonly string _lifeHackDataEndpoint;

        public PersonController(IHttpClientFactory clientFactory, IConfiguration configuration)
        {
            _clientFactory = clientFactory;
            _lifeHackDataEndpoint = configuration.GetSection("LifeHackData").GetSection("Endpoint").Value;
        }
        /// <summary>
        /// Updates a Person and his Goals relationships
        /// </summary>
        /// <param name="model">The underlying Person</param>
        /// <returns>the updated model</returns>
        [HttpPost]
        public async Task<Person> Post(Person model)
        {
            var client = _clientFactory.CreateClient();
            var response = await client.PostAsJsonAsync($"{_lifeHackDataEndpoint}/person/", model);
            var responseObject = await response.Content.ReadAsAsync<Person>();
            return responseObject;
        }
    }
}