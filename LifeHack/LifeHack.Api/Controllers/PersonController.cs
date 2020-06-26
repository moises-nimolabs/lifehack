using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
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

        public PersonController(IHttpClientFactory clientFactory)
        {
            this._clientFactory = clientFactory;
        }
        /// <summary>
        /// Updates a Person and his Goals relationships
        /// </summary>
        /// <param name="model">The underlying Person</param>
        /// <returns>the updated model</returns>
        [HttpPost]
        public async Task<Person> Post(Person model)
        {
            var request = new HttpRequestMessage(HttpMethod.Get, "http://localhost:8080/person");
            request.Method = HttpMethod.Post;
            request.Content = new StringContent(JsonConvert.SerializeObject(model));
            var client = _clientFactory.CreateClient();
            var response = await client.SendAsync(request);
            var responseObject = await response.Content.ReadAsAsync<Person>();
            return responseObject;
        }
    }
}